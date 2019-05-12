package com.rea.interview.robot.core.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.rea.interview.robot.core.exception.FeedAbortException;
import com.rea.interview.robot.util.PropertiesUtil;

public class FileInputHandler implements InputHandler {

    private BufferedReader br;

    public FileInputHandler() {
        super();
    }

    @Override
    public String nextLine() {

        try {
            return br.readLine();
        } catch (IOException e) {
            throw new FeedAbortException("error happend when processing the command file.", e);
        }
    }

    public boolean init() {

        String fileName = PropertiesUtil.getInstance().getPropertyValue("init.command.file");
        try {
            Resource resource = new ClassPathResource(fileName);
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        } catch (IOException e) {
            throw new FeedAbortException("failed to load command file.", e);

        }
        return true;

    }

    public void close() {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                throw new FeedAbortException("error happend while closing the file  handler.", e);
            }
        }
    }

}
