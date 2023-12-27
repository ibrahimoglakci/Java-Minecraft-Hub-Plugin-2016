package me.xeme.api;

public enum Ranks {
	
		
		OWNER("OWNER", 12),
		ADMIN("ADMIN", 11),
		DEVELOPER("DEVELOPER", 10), 
		SENIOR("SENIOR", 9),
		MODERATOR("MODERATOR", 8),
		MAPMAKER("MAPMAKER", 7),
		VIP("VIP", 6),
		QUANTUM("QUANTUM", 5),
		PLATINUM("PLATINUM" ,4),
		DIAMOND("DIAMOND", 3),
		GOLD("GOLD", 2),
		REGULAR("REGULAR", 1);
		
		
		
		
		private Integer ranks;
		private String rankname;
		
		
		
		
		private Ranks(String ranknames, int rank) {
			setRankname(ranknames);
			ranks = rank;
		}



		public int getRanks() {
			return ranks;
		}



		public void setRanks(int rank) {
			ranks = rank;
		}



		public String getRankname() {
			return rankname;
		}



		public void setRankname(String rankname) {
			this.rankname = rankname;
		}
		
		
	
	

}
