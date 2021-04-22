package math;

/**
 *
 * No.1041 Robots Bounded in Circle
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degrees to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 * Date: 04/20/2021
 *
 */
public class RobotsBoundedInCircle {

    public boolean bounded(String s) {
        // N: 0, E: 1, S: 2, W: 3
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int x = 0, y = 0;
        int facingDir = 0; // N
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                facingDir = (facingDir + 3) % 4;
            } else if (c == 'R') {
                facingDir = (facingDir + 1) % 4;
            } else {
                x += directions[facingDir][0];
                y += directions[facingDir][1];
            }
        }
        return x == 0 && y == 0 || facingDir != 0;
    }
}
