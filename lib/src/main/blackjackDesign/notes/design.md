components
	- nouns
	- actors, elements of the app/process/thing
what is does
	- verbs
	
start high-level, then get more into the weeds as design requires



blackjack

nouns
	- card
	- value
	- casino
	- table
	- employee
	- tip
	- suit
	- 
	- chip
	- player
	- dealer
	- deck
	- pot
	etc
	normally label nouns in squares
	look at relationships between nouns
	e.g. deck 'has a' set of cards
		a player 'is a' person
	brainstorm all nouns
		try and be exhaustive, often eliminate unecessary nouns
		think about all elements of game, not tech related
		stay top down
	
verbs
	- deal
	- bet, iterate
	- play
	- evaluate
	- repeat
	again start high-level, most generic actions
	then create subsystems for general actions
	e.g. build deck is sub of deal
		- workflow for building deck, might need another sub of build if necessary
		
		
process flow (multiple levels, at least two, no overlap between processes) for verbs and relationship map (is a and has a) for nouns
class diagrams for 'is a's relationships 



Review class notes
- careful on inferring relationship that doesn't exist
- 