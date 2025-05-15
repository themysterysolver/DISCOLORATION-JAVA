import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameDriverGUI extends JFrame {
    int n;
    int cellSize;
    GameLogic game;
    JButton[][] buttons;
    int wh=400;

    public GameDriverGUI(int n){
        this.n=n;
        if(n==6){
           declareWinner();
            SwingUtilities.invokeLater(() -> {
                System.exit(1);
            });
            return;
        }
        buttons=new JButton[n][n];
        cellSize=wh/n;
        setTitle("LEVEL-"+n);
        setSize(400,400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        game=new GameLogic(n);

        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new GridLayout(n,n));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                buttons[i][j]=new JButton();
                buttons[i][j].setBackground(new Color(100, 116, 165));
                buttons[i][j].setPreferredSize(new Dimension(cellSize-5,cellSize-5));
                buttons[i][j].setBorderPainted(true);
                buttons[i][j].setOpaque(true);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));

                int x=i,y=j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        game.clickTile(x,y);
                        displyBoard();
                        if(!game.gameIsNotOver()){
                            new GameDriverGUI(n+1);
                        }
                    }
                });
                mainPanel.add(buttons[i][j]);
            }
        }

        add(mainPanel,BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void declareWinner() {
        JOptionPane.showMessageDialog(this,"<html><div " +
                "style='text-align:center;" +
                "font-size:16px; color:#6A1B9A;'><b>CONGRATULATIONS!</b><br></div>" +
                "You have won the game!</html>");
    }

    private void displyBoard() {
        int [][] grid=game.board;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    buttons[i][j].setBackground(new Color(197, 197, 7));
                }else{
                    buttons[i][j].setBackground(new Color(100, 116, 165));
                }
            }
        }
    }
}
