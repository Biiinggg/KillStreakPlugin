package me.biiing.killstreak;

import org.bukkit.entity.Player;

public class KillTracker {

	
	private int k;
	private int d;
	private Player p;
	
	
	public int getK() {
		return k;
	}
	
	public void setK(int k) {
		this.k = k;
	}
	
	public int getD() {
		return d;
	}
	
	public void setD(int d) {
		this.d = d;
	}
	
	public Player getP() {
		return p;
	}
	
	public void setP(Player p) {
		this.p = p;
	}
}
