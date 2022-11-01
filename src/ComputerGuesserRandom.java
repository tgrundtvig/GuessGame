import java.util.Random;

public class ComputerGuesserRandom implements IGuesser
{
	private final static Random rnd = new Random();
	private int min;
	private int max;
	private int lastGuess;

	public void yourTurn() {}

	public String getName()
	{
		return "Computer guesser";
	}

	public void newGame(int min, int max, String opponent, String type)
	{
		this.min = min;
		this.max = max;
	}

	public int makeGuess()
	{
		int rangeLength = max - min + 1;
		lastGuess = rnd.nextInt(rangeLength) + min;
		return lastGuess;
	}

	public void guessFeedback(Answer answer)
	{
		switch(answer)
		{
			case TOO_LOW:
				min = (lastGuess) + 1;
				break;
			case TOO_HIGH:
				max = (lastGuess) - 1;
				break;
			case CORRECT:
				break;
			default:
				throw new RuntimeException("This should never happen!");
		}
	}

	public boolean endOfGame(int numberOfGuesses, String opponent)
	{
		return true;
	}

}
