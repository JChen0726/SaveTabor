import java.util.ArrayDeque;
import java.util.Queue;

public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    private Direction findShortestPathToMouse
            (boolean[][] lab, int cx, int cy, int mx, int my) {
        // Create a queue for all nodes we will process in breadth-first order.
        // Each node is a data structure containing the cat's position and the
        // initial direction it took to reach this point.
        Queue<Node> queue = new ArrayDeque<>();

        // Matrix for "discovered" fields
        // (I know we're wasting a few bytes here as the cat and mouse can never
        // reach the outer border, but it will make the code easier to read. Another
        // solution would be to not store the outer border at all - neither here nor
        // in the labyrinth. But then we'd need additional checks in the code
        // whether the outer border is reached.)
        boolean[][] discovered = new boolean[23][31];

        // "Discover" and enqueue the cat's start position
        discovered[cy][cx] = true;
        queue.add(new Node(cx, cy, null));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // Go breath-first into each direction
            for (Direction dir : Direction.values()) {
                int newX = node.x + dir.getDx();
                int newY = node.y + dir.getDy();
                Direction newDir = node.initialDir == null ? dir : node.initialDir;

                // Mouse found?
                if (newX == mx && newY == my) {
                    return newDir;
                }

                // Is there a path in the direction (= is it a free field in the labyrinth)?
                // And has that field not yet been discovered?
                if (!lab[newY][newX] && !discovered[newY][newX]) {
                    // "Discover" and enqueue that field
                    discovered[newY][newX] = true;
                    queue.add(new Node(newX, newY, newDir));
                }
            }
        }

        throw new IllegalStateException("No path found");
    }
}