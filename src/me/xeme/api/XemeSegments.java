package me.xeme.api;

public class XemeSegments {
	
	public static XemeSegments segments;
	
	
	public enum GameSegments {
		
		HUB, SurvivalGames, ArenaPvP, FreeForAll;
		
	}
	
	
	
	public void setGameSegments(XemeSegments segment) {
		 
		segments = segment;
		
	}
	
	
	public XemeSegments getSegments() {
		
		return segments;
	}

}
