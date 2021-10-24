import java.util.ArrayList;

/**
 * Sample Usage
 */
class RobotWithCommand {
    public static void main(String[] args) {
        // The Components of the robot
        Camera GeoffreyCam = new Camera();
        SoundRecorder GeoffreySoundSystem = new SoundRecorder();
        Brain GeoffreyBrain = new Brain();

        // The Robot
        CommandRobot Geoffrey = new CommandRobot(GeoffreyCam,
                GeoffreySoundSystem, GeoffreyBrain);

        Command[] commands = {
                new SoundRecordingCommand(GeoffreyCam, GeoffreySoundSystem,
                        GeoffreyBrain, true),
                new SoundlessRecordingCommand(GeoffreyCam, GeoffreyBrain, true),
                new SoundRecordingCommand(GeoffreyCam, GeoffreySoundSystem,
                        GeoffreyBrain, false),
                new SoundlessRecordingCommand(GeoffreyCam, GeoffreyBrain,
                        false),
        };

        for (Command cmd : commands){
            Geoffrey.setCommand(cmd);
        }

        Geoffrey.executeCommand();
    }
}

/**
 * A robot Class
 */
class CommandRobot {
    private final ArrayList<Command> command;
    private final Camera camera;
    private final SoundRecorder sound;
    private final Brain brain;

    public CommandRobot(Camera theCamera, SoundRecorder theSound,
                        Brain theBrain){
        this.camera = theCamera;
        this.sound = theSound;
        this.brain = theBrain;
        this.command = new ArrayList<>();
    }

    /**
     * Sets the theCommand for the robot to execute
     * @param theCommand The theCommand that the robot wants to execute
     */
    public void setCommand(Command theCommand) {
        command.add(theCommand);
    }

    /**
     * Executes the command saved in the robot
     */
    public void executeCommand() {
        for (Command cmd : this.command){
            cmd.execute();
        }
    }
}

/**
 * The Command Interface
 */
interface Command {
    void execute();
}

/**
 * The command object that turns starts a recording
 */
class SoundRecordingCommand implements Command {
    private final Camera camera;
    private final SoundRecorder recorder;
    private final Brain brain;
    private final boolean onOff;

    /**
     * Constructor
     *
     * @param theCamera the Camera object associated with this command
     * @param theRecorder the Brain object associated with this command
     * @param theBrain the Brain object associated with this command
     */
    public SoundRecordingCommand(Camera theCamera, SoundRecorder theRecorder,
                                 Brain theBrain, boolean onOff) {
        this.camera = theCamera;
        this.recorder = theRecorder;
        this.brain = theBrain;
        this.onOff = onOff;
    }

    /**
     * Executes the command
     */
    @Override
    public void execute() {
        if (onOff) {
            camera.on();
            recorder.open();
            brain.receiveCameraData();
        } else {
            camera.off();
            recorder.close();
            brain.saveCameraData();
        }
    }
}

/**
 * The command object that turns starts a recording
 */
class SoundlessRecordingCommand implements Command {
    private final Camera camera;
    private final Brain brain;
    private final boolean onOff;

    /**
     * Constructor
     *
     * @param theCamera the Camera object associated with this command
     * @param theBrain the Brain object associated with this command
     */
    public SoundlessRecordingCommand(Camera theCamera, Brain theBrain,
                                     boolean onOff) {
        this.camera = theCamera;
        this.brain = theBrain;
        this.onOff = onOff;
    }

    /**
     * Executes the command
     */
    @Override
    public void execute() {
        if (onOff) {
            camera.on();
            brain.receiveCameraData();
        } else {
            camera.off();
            brain.saveCameraData();
        }
    }
}



