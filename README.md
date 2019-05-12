# Toy-robot-simulator
Here is the code I developed .  There are some  instructions for my code.

- feed.properties have the configuration entries.
    The entry 'init.input.source' controls if the application reads data from standard output or specified file which is specified by another entry 'init.command.file'
    init.axis.x and init.axis.y are used to initialize the grid
    init.commandset and init.command.directionset are used for command validation purpose.

- Command.txt keeps the commands to be executed in batch.

- Used one Spring API to read the feed.properties.  Not using Spring/Spring boot to do all the configuration but it can be done certainly.

- Command,Strategy,Singleton,Factory etc pattern are used.

- JDK 1.8 is used. Spring Tool Suite ( developed based on Eclipse) is used for my development.

- Call FeedMain class in order to run the application.