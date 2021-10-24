class CommandlessRobot {
    private final Camera camera;
    private final SoundRecorder sound;
    private final Brain brain;

    public CommandlessRobot(){
        camera = new Camera();
        sound = new SoundRecorder();
        brain = new Brain();
    }

    public void StartRecording(boolean withSound){
        this.camera.on();
        if (withSound){
            this.sound.open();
        }
        this.brain.receiveCameraData();
    }

    public void StopRecording(){
        this.camera.off();
        this.sound.close();
        this.brain.saveCameraData();
    }
    // ...
}

class RobotWithOutCommand {
    public static void main(String[] args) {
        CommandlessRobot rob = new CommandlessRobot();
        rob.StartRecording(true);
        rob.StopRecording();
    }
}
