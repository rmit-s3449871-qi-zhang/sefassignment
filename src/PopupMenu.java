import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
public class PopupMenu extends JFrame {
  JPopupMenu menu = new JPopupMenu("Popup");

  class MyLabel extends JLabel {
    public MyLabel(String text) {
      super(text);
      addMouseListener(new PopupTriggerListener());
    }

    class PopupTriggerListener extends MouseAdapter {
      public void mousePressed(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseReleased(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
          menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
      }

      public void mouseClicked(MouseEvent ev) {
      }
    }
  }

  JLabel label = new MyLabel("right-click");

  public PopupMenu() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuItem item = new JMenuItem("Robot");
    item.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Robot");
      }
    });
    menu.add(item);

    item = new JMenuItem("Source");
    item.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Source");
      }
    });
    menu.add(item);

    getContentPane().add(label);
    pack();
    setSize(300, 100);
  }

  public static void main(String[] args) {
    new PopupMenu().setVisible(true);
  }
}