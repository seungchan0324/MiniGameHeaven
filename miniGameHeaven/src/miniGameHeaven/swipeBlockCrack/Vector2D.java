package swipeBlockCrack;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(this.x - other.x, this.y - other.y);
    }

    public Vector2D normalize() {
        double length = Math.sqrt(x * x + y * y);
        if (length != 0) {
            return new Vector2D(x / length, y / length);
        } else {
            return new Vector2D(0, 0);
        }
    }
}