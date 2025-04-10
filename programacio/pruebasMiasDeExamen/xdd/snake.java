import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SnakeGame extends JPanel implements ActionListener, KeyListener {
    ArrayList<Point> snake = new ArrayList<>();
    Point food;
    int dirX = 1, dirY = 0; // Direcció inicial (dreta)
    Timer timer = new Timer(100, this);
    final int SIZE = 10;

    public SnakeGame() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        snake.add(new Point(50, 50)); // Cap de la serp
        generaMenjar();
        timer.start();
    }

    void generaMenjar() {
        Random r = new Random();
        int x = r.nextInt(getWidth() / SIZE) * SIZE;
        int y = r.nextInt(getHeight() / SIZE) * SIZE;
        food = new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for (Point p : snake) g.fillRect(p.x, p.y, SIZE, SIZE);

        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, SIZE, SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mou la serp
        Point cap = new Point(snake.get(0).x + dirX * SIZE, snake.get(0).y + dirY * SIZE);
        // Comprova col·lisions
        if (snake.contains(cap) || cap.x < 0 || cap.y < 0 || cap.x >= getWidth() || cap.y >= getHeight()) {
            timer.stop(); // Has perdut
            JOptionPane.showMessageDialog(this, "Game Over!");
            return;
        }

        snake.add(0, cap); // Afegeix nou cap

        // Comprova si ha menjat
        if (cap.equals(food)) {
            generaMenjar();
        } else {
            snake.remove(snake.size() - 1); // Elimina cua
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: if (dirY == 0) { dirX = 0; dirY = -1; } break;
            case KeyEvent.VK_DOWN: if (dirY == 0) { dirX = 0; dirY = 1; } break;
            case KeyEvent.VK_LEFT: if (dirX == 0) { dirX = -1; dirY = 0; } break;
            case KeyEvent.VK_RIGHT: if (dirX == 0) { dirX = 1; dirY = 0; } break;
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        SnakeGame joc = new SnakeGame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(joc);
        frame.setVisible(true);
    }
}
