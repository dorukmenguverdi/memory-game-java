import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Game board that holds and manages the memory cards
public class GameBoard extends JPanel {

    private List<Card> cards = new ArrayList<>();

    private Card firstSelected = null;
    private Card secondSelected = null;
    private Timer flipBackTimer;

    public GameBoard() {
        // Setup layout and appearance
        setLayout(new GridLayout(4, 4, 10, 10)); // 4x4' lük kart düzeni
        setBackground(new Color(173, 216, 230)); // Arkaplan beyaz olsun
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        // Define 8 unique animal types (2 of each will be added)
        String[] animalNames = {"blackSheep", "cat", "dog1",
                                "dog2", "fox", "panda", "squirrel","whiteSheep"
        };

        // Create and shuffle cards
        for (String name : animalNames) {
            ImageIcon image = new ImageIcon("src/images/" + name + ".png");
            cards.add(new Card(name, image));
            cards.add(new Card(name, image));
        }


        Collections.shuffle(cards);

        // Add each card to the GUI and set up click handler
        for (Card card : cards) {
            add(card.getButton());

            card.getButton().addActionListener(e ->{
                handleCardClick(card);
                    });
        }

        // Timer for flipping cards back if they don't match
        flipBackTimer = new Timer(1000, e-> flipBack());
        flipBackTimer.setRepeats(false);

    }

    // Handles what happens when a card is clicked
    private void handleCardClick(Card selectedCard) {

        if (selectedCard.isFlipped() || selectedCard.isMatched()) return;

        selectedCard.flip(); //

        if (firstSelected == null) {
            firstSelected = selectedCard;
        }
        else {
            secondSelected = selectedCard;

            if (firstSelected.getName().equals(secondSelected.getName())) {
                // Eşleşme varsa açık kalsın
                firstSelected.setMatched(true);
                secondSelected.setMatched(true);
                firstSelected = null;
                secondSelected = null;
            }
            else {
                flipBackTimer.start();
            }
        }
    }

    // Flips cards back if not matched
    private void flipBack() {
        if (firstSelected != null) firstSelected.flip();
        if (secondSelected != null) secondSelected.flip();
        firstSelected = null;
        secondSelected = null;
    }

}
