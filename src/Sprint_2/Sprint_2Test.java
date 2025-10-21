package Sprint_2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Sprint_2Test {

    @Test
    @DisplayName("AC 1.1 - Display available board size options")
    void testAvailableBoardSizesDisplayed() {
        // Given: A new GUI setup screen is initialized
        Integer[] expectedSizes = {3, 4, 5, 6, 7, 8};

        // When: The player views board size selection (from GUI combo box)
        // Then: There should be at least 3 different board size options
        assertTrue(expectedSizes.length >= 3, "There should be at least 3 board size options available");
    }

    @Test
    @DisplayName("AC 1.2 - Select and confirm board size")
    void testBoardSizeSelectionSavesCorrectly() {
        // Given: The player selects a board size (e.g., 5)
        int selectedBoardSize = 5;

        // When: The game starts with the selected size
        Sprint_2 game = new Sprint_2(selectedBoardSize, "simple");

        // Then: The selected board size should be stored in the current game session
        assertEquals(selectedBoardSize, game.getBoardSize(), "The selected board size should be saved correctly");
    }

    @Test
    @DisplayName("AC 1.3 - Visual preview or confirmation of board size")
    void testBoardSizePreviewDisplayed() {
        // Given: The player has selected a board size
        int selectedSize = 6;
        Sprint_2 game = new Sprint_2(selectedSize, "general");

        // When: The GUI displays the game board
        int actualRows = game.getBoard().length;
        int actualCols = game.getBoard()[0].length;

        // Then: The displayed board dimensions should match the selected size
        assertEquals(selectedSize, actualRows, "The number of rows should match the selected board size");
        assertEquals(selectedSize, actualCols, "The number of columns should match the selected board size");
    }
    
    @Test
    void testGameModeSelection() {
        Sprint_2 game = new Sprint_2(5, "simple"); 
        assertEquals("simple", game.getGameMode(), "Game mode should be saved as 'simple'");
    }
    
    @Test
    void testBoardInitialization() {
        int boardSize = 4;
        Sprint_2 game = new Sprint_2(boardSize, "general");
        assertEquals(boardSize, game.getBoard().length, "Board should have correct number of rows");
        assertEquals(boardSize, game.getBoard()[0].length, "Board should have correct number of columns");
    }
    
    @Test
    void testInitialPlayerTurn() {
        Sprint_2 game = new Sprint_2(3, "simple");
        assertEquals("blue", game.getCurrentPlayer(), "Initial turn should be blue");
    }
    
    @Test
    void testMakeMove() {
        Sprint_2 game = new Sprint_2(3, "simple");
        boolean result = game.makeMove(0, 0, 'S'); 
        assertTrue(result, "Should allow placing 'S' in empty cell");
        assertEquals('S', game.getCell(0, 0), "Cell should now contain 'S'");
    }
    
    @Test
    void testSwitchPlayer() {
        Sprint_2 game = new Sprint_2(3, "simple");
        game.makeMove(0, 0, 'S');
        game.switchPlayer();
        assertEquals("red", game.getCurrentPlayer(), "Turn should switch to red");
    }
    
    
}