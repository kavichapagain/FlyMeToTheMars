
public interface Spaceship {
	public boolean launch();
	public boolean land();
	public boolean canCarry(Item cargo);
	public void carry(Item cargo);
}
