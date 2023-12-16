This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

- "move" + a direction (north, south, east, west) --> allows player to move to the corresponding room to the direction, if it exists. 
- "grab" + a tool --> picks up specified tool if in the same room as the player's current location
- "drop" + a tool --> drops the specified tool into the room of the player's current location. Also calculates and prints out only if the room is completed after dropping the tool within.
- "explore" + a room --> prints the contents of the given room, if it exists and is the same as the player's current location.
- "list" + inventory --> prints the contents of the player's inventory. List can only be used for the inventory. 

final room/appliance/tool pairings:
- Kitchen- stove + sponge
- Dining Room- table + hammer
- Living Room- rug + broom
- Entryway- light + screwdriver
- Bathroom- toilet + plunger
- Bedroom- bed + sheets
The layout of my game is essentially a 3x2 grid, with each cell representing a room. The top row, from west to east, is kitchen, living room, bathroom. The bottom row is dining room, entryway, bedroom. 


In lieu of a help command, I made my error checks pretty descriptive, providing the user with information about why the attempted command did not work. For example, if the verb of the user's input is not recognized, the response also provides the availible commands to help the user. 
