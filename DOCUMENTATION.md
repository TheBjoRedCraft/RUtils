# Documentation - RedUtilities

## Commands
### Language
- Usage: /language
- Description: Toggles the Language from a player between German and English
### GameMode
- Usage: /gamemode %gamemode% %player% - /gamemode %gamemode%
- Description: Changes the Game Mode of a player
### Rename
- Usage: /gamemode %gamemode% %player% - /gamemode %gamemode%
- Description: Changes the Game Mode of a player
### Difficulty
- Usage: /difficulty %difficulty%
- Description: Changes the Difficulty of the World from the player
### Clear
- Usage: /clear %player% - /clear
- Description: Cleares the Inventory of a player
### Stop
- Usage: /stop %time%
- Description: Stops the Server with a countdown
### Restart
- Usage: /restart %time%
- Description: Restarts the Sevrer with a countdown
### Kick
- Usage: /kick %player% %reason% - /kick %player%
- Description: Kicks a player with a reason
### Ban
- Usage: /ban %player% %reason% - /ban %player%
- Description: Bans a player with a reason
### Mute
- Usage: /mute %player% %reason% - /mute %player%
- Description: Mutes a player with a reason
## Permission to Event System
What is a Permission to Event System?
Example -> onBlockBreak check if player has permission to break a block, if yes -> do it, if not cancel it

 ## Events:
- BlockBreak - Permission: rutils.event.can.destroy
- BlockPlace - Permission: rutils.event.can.build
- AttackPlayer - Permission: rutils.event.can.attack
- CanBeAttacked - Permission: rutils.event.can.attacked