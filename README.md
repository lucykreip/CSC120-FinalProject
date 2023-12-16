# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

 I played around witha  couple different ideas of how I was going to implement the idea of "fixing" broken appliences and "using" tools. Though the front-end design may not be as aesthetic, I believe the route I chose for how to implement this was the most straightforward, and worked the best with the other moving parts in the game. I thought about having the tool determine what appliance it was to fix, knowing its location and use cases. But this gave the tool too much to do and overcomplicated its association with the Player and Appliance classes. Instead, I based my game more around the idea of pairing up the tools and appliances within a room. I found this more straightforward, and I was able to focus more of my efforts on how I was going to traverse my game and figuring out the structure of the game map instead. Branching off from this, I considered trying to make a Graph using Guava work, but I found that when trying to reconcile how to store and traverse my game map as I designed it, it just made more sense to me to use Hashtables and my Locaton class. The built in class of Hashtable and the methods it already had allowed me to construct my game how I imagined it, and to simply and easily traverse from one room to another, while applying and storing these values and building off of them. 

 My overall approach to the project was to try and get my core class down first, with a general idea of what else I still needed to implement, so that I could build bigger and branch off more from more basic code. I got the basics of my Room, Tool, Player, and Appliance classes down first. Then I tackled how I would traverse my game, making the Location and GameMap classes to help. The other classes came after, using Game to mesh everything together, and my Command classes to fully implement a running and working game. I started with what I knew was essential, and then just kind of let my program lead me to what I needed next, and continued to update my base classes if I needed other information from them. I figured out how to divide up the work of the project between my classes, making sure all of them are only doing the work that they need to/are capable of. I also figured out how to implement the location and movement aspect of my game, which was a part that I was especially nervous about. Of things to change/implement differently, I would change the ending of my game, maybe make an advanced stage where only a completed house can be "sold". Zephyr gave me advice about having an explore function that could be applied to each of my rooms, printing out or showing the contents somehow. This was a really integral part of my program as it turned out, because it allows the player to understand what exactly is in each room, and thus infer what tools belonged in which rooms and with which appliances. If I could go back in the past, I would tell myself to really make sure I have a very strong map/idea of what classes I needed and what my overall goal was. I felt like I didn't plan this out well enough and that made it very easy to get sucked into rabbit holes of making a bunch of things I didn't need. 
