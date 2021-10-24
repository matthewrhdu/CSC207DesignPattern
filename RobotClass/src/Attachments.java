abstract class Attachments {}

/**
 * A SoundRecorder for the robot.
 *
 * If the SoundRecorder is ON, then the recorderStatus is true.
 * If the SoundRecorder is OFF, then the recorderStatus is false.
 */
class SoundRecorder extends Attachments {
    private boolean recorderStatus;

    /**
     * Opens the SoundRecorder
     */
    public void open(){
        if (!recorderStatus){
            System.out.println("The Sound Recorder now opened");
            recorderStatus = true;
        } else {
            System.out.println("The Sound Recorder already open");
        }
    }

    /**
     * Closes the SoundRecorder
     */
    public void close(){
        if (recorderStatus){
            System.out.println("The Sound Recorder now closed");
            recorderStatus = false;
        } else {
            System.out.println("The Sound Recorder currently closed");
        }
    }
}

/**
 * The Brain of the robot. It receives the video feed from the robot or saves
 * the video feed for future use
 */
class Brain extends Attachments {
    /**
     * Receive the camera data
     */
    public void receiveCameraData(){
        System.out.println("Brain Received Data");
    }

    /**
     * Saves the data received
     */
    public void saveCameraData(){
        System.out.println("Data has been saved in the Brain!");
    }
}

/**
 * The Camera for the Robot
 */
class Camera extends Attachments {
    /**
     * Turn the Camera On
     */
    public void on() {
        System.out.println("Camera is now on");
    }

    /**
     * Turn the Camera off
     */
    public void off() {
        System.out.println("Camera is now off");
    }
}
