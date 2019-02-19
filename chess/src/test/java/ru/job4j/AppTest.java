package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 18.02.2019.
 */
public class AppTest {

    /**
     * Создаем объект логики наших фигур.
     */
    private Logic logicFigures = new Logic();

    /**
     * Метод заполняющий объект logicFigures фигурами.
     */
    private void fillWithFigures(Logic logic) {
        logic.add(new PawnBlack(Cell.A7));
        logic.add(new PawnBlack(Cell.B7));
        logic.add(new PawnBlack(Cell.C7));
        logic.add(new PawnBlack(Cell.D7));
        logic.add(new PawnBlack(Cell.E7));
        logic.add(new PawnBlack(Cell.F7));
        logic.add(new PawnBlack(Cell.G7));
        logic.add(new PawnBlack(Cell.H7));
        logic.add(new RookBlack(Cell.A8));
        logic.add(new KnightBlack(Cell.B8));
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new QueenBlack(Cell.D8));
        logic.add(new KingBlack(Cell.E8));
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new KnightBlack(Cell.G8));
        logic.add(new RookBlack(Cell.H8));
        logic.add(new PawnWhite(Cell.A2));
        logic.add(new PawnWhite(Cell.B2));
        logic.add(new PawnWhite(Cell.C2));
        logic.add(new PawnWhite(Cell.D2));
        logic.add(new PawnWhite(Cell.E2));
        logic.add(new PawnWhite(Cell.F2));
        logic.add(new PawnWhite(Cell.G2));
        logic.add(new PawnWhite(Cell.H2));
        logic.add(new RookWhite(Cell.A1));
        logic.add(new KnightWhite(Cell.B1));
        logic.add(new BishopWhite(Cell.C1));
        logic.add(new QueenWhite(Cell.D1));
        logic.add(new KingWhite(Cell.E1));
        logic.add(new BishopWhite(Cell.F1));
        logic.add(new KnightWhite(Cell.G1));
        logic.add(new RookWhite(Cell.H1));
    }

    /**
     * Test проверяет логику.
     */
    @Test
    public void testLogicWhenPawnBlack() {
        this.fillWithFigures(this.logicFigures);
        boolean actual = logicFigures.move(Cell.B7, Cell.B6);
        assertThat(actual, is(true));
    }

    /**
     * Test проверяет ход фигуры Слон.
     */
    @Test
    public void testBishop() {
        BishopBlack bishop = new BishopBlack(Cell.H8);
        Cell[] actual = bishop.way(bishop.position(), Cell.A1);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }

    /**
     * Test проверяет ход фигуры Ладья.
     */
    @Test
    public void testRook() {
        RookBlack rook = new RookBlack(Cell.H8);
        Cell[] actual = rook.way(rook.position(), Cell.H1);
        Cell[] expected = {Cell.H7, Cell.H6, Cell.H5, Cell.H4, Cell.H3, Cell.H2, Cell.H1};
        assertThat(actual, is(expected));
    }

    /**
     * Test проверяет ход фигуры Конь.
     */
    @Test
    public void testKnight() {
        KnightBlack knight = new KnightBlack(Cell.E8);
        Cell[] actual = knight.way(knight.position(), Cell.F6);
        Cell[] expected = {Cell.F6};
        assertThat(actual, is(expected));
    }

    /**
     * Test проверяет ход фигуры Король.
     */
    @Test
    public void testKing() {
        KingBlack king = new KingBlack(Cell.E8);
        Cell[] actual = king.way(king.position(), Cell.F7);
        Cell[] expected = {Cell.F7};
        assertThat(actual, is(expected));
    }

    /**
     * Test проверяет ход фигуры Ферзь.
     */
    @Test
    public void testQueen() {
        QueenBlack queen = new QueenBlack(Cell.E8);
        Cell[] actual = queen.way(queen.position(), Cell.E1);
        Cell[] expected = {Cell.E7, Cell.E6, Cell.E5, Cell.E4, Cell.E3, Cell.E2, Cell.E1};
        assertThat(actual, is(expected));
    }

    /**
     * Test проверяет ход фигуры Пешка.
     */
    @Test
    public void testPawn() {
        PawnBlack pawn = new PawnBlack(Cell.E7);
        Cell[] actual = pawn.way(pawn.position(), Cell.E6);
        Cell[] expected = {Cell.E6};
        assertThat(actual, is(expected));
    }

    /**
     * Test проверяет выброс исключения ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void testLogicFigureRookBlackWhenImpossibleMove() {
        RookBlack rook = new RookBlack(Cell.A8);
        rook.way(rook.position(), Cell.H1);
    }

    /**
     * Test проверяет выброс исключения OccupiedWayException.
     */
    @Test(expected = OccupiedWayException.class)
    public void testLogicFigureRookBlackWhenError() {
        fillWithFigures(this.logicFigures);
        logicFigures.move(Cell.A8, Cell.A4);
    }

    /**
     * Test проверяет выброс исключения FigureNotFoundException.
     */
    @Test(expected = FigureNotFoundException.class)
    public void testLogicFigureRookBlackWhenNotFound() {
        fillWithFigures(this.logicFigures);
        logicFigures.move(Cell.A6, Cell.A4);
    }
}
