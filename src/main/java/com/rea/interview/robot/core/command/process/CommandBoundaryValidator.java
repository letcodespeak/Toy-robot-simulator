package com.rea.interview.robot.core.command.process;

import com.rea.interview.robot.util.PropertiesUtil;

public class CommandBoundaryValidator implements CommandValidationStrategy {

    private int x_tobe;
    private int y_tobe;

    private static final int max_x = Integer.parseInt(PropertiesUtil.getInstance().getPropertyValue("init.axis.x"));
    private static final int max_y = Integer.parseInt(PropertiesUtil.getInstance().getPropertyValue("init.axis.y"));

    public CommandBoundaryValidator(int x, int y) {
        super();
        this.x_tobe = x;
        this.y_tobe = y;

    }

    @Override
    public int validate() {

        boolean valid = true;
        if (x_tobe < 0 || x_tobe > max_x)
            valid = false;
        if (y_tobe < 0 || y_tobe > max_y)
            valid = false;

        if (!valid) {
            System.out.println("The requested coordinates [X=" + x_tobe + ",Y=" + y_tobe + "] is out of the [[X=" + max_x + ",Y=" + max_y + "] grid. Command ignored.");
        }

        if (valid)
            return 0;
        else
            return -1;
    }

}
