import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Random;
import javax.swing.*;

public class BrainrotFinal {

    public static void main(String[] args) {

        JFrame frame = new JFrame("💀 Brainrot Translator ✨");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(10, 10, 10));
        frame.setLayout(new BorderLayout(15, 15));

        // TITLE
        JLabel title = new JLabel("💅 Brainrot → Formal:)(but make it ICONIC!!)", JLabel.CENTER);
        title.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
        title.setForeground(new Color(255, 20, 147));
        frame.add(title, BorderLayout.NORTH);

        // INPUT
        JTextArea inputArea = new JTextArea();
        styleTextArea(inputArea);

        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 255, 255), 2),
                "🧠 Drop your chaotic thoughts bestie",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(0, 255, 255)
        ));

        // OUTPUT
        JTextArea outputArea = new JTextArea();
        styleTextArea(outputArea);
        outputArea.setEditable(false);

        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 20, 147), 2),
                "🎩 Civilized Translation (we classy now)",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(255, 20, 147)
        ));

        JPanel center = new JPanel(new GridLayout(2, 1, 10, 10));
        center.setBackground(new Color(10, 10, 10));
        center.add(inputScroll);
        center.add(outputScroll);

        frame.add(center, BorderLayout.CENTER);

        // BUTTONS
        JButton translateBtn = createButton("✨ Translate");
        JButton clearBtn = createButton("🧹 Reset");
        JButton randomBtn = createButton("🎲 Chaos");
        JButton copyBtn = createButton("📋 Copy");

        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(10, 10, 10));
        buttons.add(randomBtn);
        buttons.add(translateBtn);
        buttons.add(copyBtn);
        buttons.add(clearBtn);

        frame.add(buttons, BorderLayout.SOUTH);

        // ACTIONS
        translateBtn.addActionListener(e -> {
            String input = inputArea.getText();

            if (input.trim().isEmpty()) {
                outputArea.setText("💀 bro typed nothing... try again");
                return;
            }

            outputArea.setText(translate(input));
        });

        clearBtn.addActionListener(e -> {
            inputArea.setText("");
            outputArea.setText("");
        });

        copyBtn.addActionListener(e -> {
            StringSelection selection = new StringSelection(outputArea.getText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        });

        randomBtn.addActionListener(e -> {
            String[] chaos = {
                "bro is delulu fr 💀",
                "this food bussin no cap",
                "he got insane rizz ong",
                "this party lit af",
                "why he acting sus bruh",
                "this fit fire you got drip",
                "lowkey that was cringe ngl",
                "he think he the main character 💀"
            };

            inputArea.setText(chaos[new Random().nextInt(chaos.length)]);
        });

        frame.setVisible(true);
    }

    private static void styleTextArea(JTextArea area) {
        area.setBackground(new Color(20, 20, 20));
        area.setForeground(new Color(0, 255, 200));
        area.setCaretColor(Color.PINK);
        area.setFont(new Font("Consolas", Font.BOLD, 15));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private static JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(30, 30, 30));
        btn.setForeground(new Color(0, 255, 255));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createLineBorder(new Color(255, 20, 147)));
        return btn;
    }

    public static String translate(String text) {

        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");

        String[][] dict = {

            {"delulu", "is completely detached from reality"},
            {"no cap", "I am being entirely truthful"},
            {"fr", "truly"},
            {"ngl", "I must admit"},
            {"lowkey", "to some extent"},
            {"highkey", "very strongly"},
            {"bussin", "exceptionally delicious"},
            {"rizz", "exceptional charm"},
            {"sus", "suspicious"},
            {"lit", "extremely exciting"},
            {"ong", "I swear"},
            {"af", "to an extreme degree"},
            {"bro", "my friend"},
            {"bruh", "my friend"},
            {"vibe", "atmosphere"},
            {"fire", "excellent"},
            {"mid", "average"},
            {"cringe", "embarrassing"},
            {"drip", "stylish appearance"},
            {"cap", "a lie"},
            {"bet", "agreed"},
            {"yeet", "throw forcefully"},
            {"gonna", "going to"},
            {"wanna", "want to"},
            {"finna", "about to"},
            {"main character", "the central figure"},
            {"npc", "someone lacking individuality"}
        };

        for (String[] pair : dict) {
            text = text.replaceAll("\\b" + pair[0] + "\\b", pair[1]);
        }

        // FUNKY OUTPUT STYLE
        String[] endings = {
                " 💅✨",
                " 😌",
                " 🤝",
                " 📜",
                " 🧠",
                " 💀 (respectfully)",
                " 🔥"
        };

        String result = Character.toUpperCase(text.charAt(0)) + text.substring(1);

        return "🎯 Translation:\n\n" + result + "." +
                endings[new Random().nextInt(endings.length)];
    }
}