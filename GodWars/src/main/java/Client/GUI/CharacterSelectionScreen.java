package Client.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CharacterSelectionScreen extends JFrame {
    private static final int GRID_ROWS = 3;
    private static final int GRID_COLS = 7;
    private JButton selectedButton = null;
    private JLabel player1Label;
    private JLabel player2Label;
    
    public CharacterSelectionScreen() {
        setTitle("Character Selection - Super Smash Bros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);
        
        // Title Panel
        JPanel titlePanel = createTitlePanel();
        add(titlePanel, BorderLayout.NORTH);
        
        // Character Grid Panel
        JPanel gridPanel = createCharacterGrid();
        add(gridPanel, BorderLayout.CENTER);
        
        // Player Info Panel
        JPanel bottomPanel = createBottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);
        
        setSize(1200, 800);
        setLocationRelativeTo(null);
    }
    
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 40, 40));
        panel.setPreferredSize(new Dimension(0, 60));
        
        JLabel titleLabel = new JLabel("COMBATE INDIVIDUAL");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);
        
        return panel;
    }
    
    private JPanel createCharacterGrid() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS, 2, 2));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create character slots
        for (int i = 0; i < GRID_ROWS * GRID_COLS; i++) {
            final int index = i;
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(70, 70));
            
            // Alternate colors for visual effect
            if ((i / GRID_COLS + i % GRID_COLS) % 2 == 0) {
                button.setBackground(new Color(70, 130, 180));
            } else {
                button.setBackground(new Color(100, 149, 237));
            }
            
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            button.setFocusPainted(false);
            
            // Add selection effect
            button.addActionListener(event -> selectCharacter(button, index));
            
            // Hover effect
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (button != selectedButton) {
                        button.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                    }
                }
                
                @Override
                public void mouseExited(MouseEvent e) {
                    if (button != selectedButton) {
                        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    }
                }
            });
            
            panel.add(button);
        }
        
        return panel;
    }
    
    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 0));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.setPreferredSize(new Dimension(0, 150));
        
        // Player 1 Panel
        JPanel player1Panel = createPlayerPanel("Jugador 1", Color.RED, 1);
        panel.add(player1Panel);
        
        // Question Mark Panel (Random/Empty slot)
        JPanel questionPanel = createQuestionPanel();
        panel.add(questionPanel);
        
        // Player 2 Panel (CPU)
        JPanel player2Panel = createCPUPanel();
        panel.add(player2Panel);
        
        return panel;
    }
    
    private JPanel createPlayerPanel(String playerName, Color bgColor, int playerNum) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        // Player name label
        JLabel nameLabel = new JLabel(playerName, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(bgColor.darker());
        panel.add(nameLabel, BorderLayout.NORTH);
        
        // Icon area
        JLabel iconLabel = new JLabel("✋", SwingConstants.CENTER);
        iconLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        iconLabel.setForeground(Color.WHITE);
        
        if (playerNum == 1) {
            player1Label = iconLabel;
        }
        
        panel.add(iconLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createQuestionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(150, 150, 150));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        JLabel questionLabel = new JLabel("?", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 80));
        questionLabel.setForeground(Color.BLACK);
        panel.add(questionLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createCPUPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(100, 100, 100));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        // CPU Info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(80, 80, 80));
        
        JLabel cpuLabel = new JLabel("Al azar");
        cpuLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cpuLabel.setForeground(Color.WHITE);
        cpuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel levelLabel = new JLabel("Niv. CPU: 3");
        levelLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        levelLabel.setForeground(Color.WHITE);
        levelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        infoPanel.add(Box.createVerticalGlue());
        infoPanel.add(cpuLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        infoPanel.add(levelLabel);
        infoPanel.add(Box.createVerticalGlue());
        
        panel.add(infoPanel, BorderLayout.EAST);
        
        // CPU character display
        JLabel cpuIcon = new JLabel("?", SwingConstants.CENTER);
        cpuIcon.setFont(new Font("Arial", Font.BOLD, 60));
        cpuIcon.setForeground(Color.WHITE);
        player2Label = cpuIcon;
        
        panel.add(cpuIcon, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void selectCharacter(JButton button, int index) {
        // Deselect previous
        if (selectedButton != null) {
            selectedButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        }
        
        // Select new
        selectedButton = button;
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        
        // Update player display
        if (player1Label != null) {
            player1Label.setText("✓");
        }
        
        System.out.println("Character slot " + index + " selected!");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CharacterSelectionScreen frame = new CharacterSelectionScreen();
                frame.setVisible(true);
            }
        });
    }
}