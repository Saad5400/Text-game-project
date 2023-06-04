# Project Name

- Erased

# Group members and contributions

- Saad Batwa: Project supervision and contributions to programming
- Rayan Adeeb: Combat system programming
- Eyad Alsulami: Program improvement and programming contributions
- Sultan Alshehri: Story and dialogues writing and programming
- Jawad Alharbi: Writing javadoc and designing the game
- Abdulaziz Alqurashi: Program testing & debugging and design document

# Project description

- "Erased" is a text-based RPG adventure game where you play as a protagonist with no memories of their past. Explore the mysterious game world, interact with characters, and make choices that will influence the outcome of the game. The game features turn-based combat, and puzzles. Advance through the story by deciding which alliances to make. Uncover the truth about your past by making strategic decisions and forge a new future.

# How to play the game?

To play the game, run the program using the execute command on the terminal, otherwise, you can run the program using codespace or VS code or any IDE of your choice.
The player experiences the fights by pressing one of the numbers to progress the game and move from one stage to the next one, until the final stage is reached and the game ends based on the player's choices.

# Methods description

The game was built by creating various OOP-methods and classes:

- `App`: The main class
    - `+ main(args: String[]): void`: The main method
    - `+ getLastPlayedRoom(): int`: Get last played room from a save file
    - `+ void setLastPlayedRoom(roomIndex: int): void`: Save the last played room

- `Room`
    - `+ start(): void`: Start the room by first starting the event then the options
    - `+ setEvent(event: Runnable): void`: Set the event of the room
    - `+ setOptions(options: Option...): void`: Set the options of the room

- `Option`
    - `+ Option(text: String, action: Runnable)`: The constructor which takes the text and the action of the option

- `RoomsConstructor`: The class responsible for creating the rooms
    - `+ storyRoomX(): Room`: Create the story room X (X is the room number)
    - `+ stageRoomX(): Room`: Create the stage room X (X is the room number)
    - `+ finalStageRoom(): Room`: Create the final stage room

- `Character`: The abstract base class that represents a character
    - `+ takeDamage(damage: int): void`: Take damage and call the die method if the character's health is less than or equal to 0
    - `+ abstract die(): void`: Method called when the character dies

- `Player`: The class that represents the player
    - `+ die(): void`: Print the game over message and exit the program

- `Enemy`: The class that represents an enemy
    - `+ die(): void`: Print the enemy defeated message

# Self-taught concepts
- Lambda functions
- Colorful user interface
- Type conversion to convert strings to integers
- Sleeping the thread
- vargs (unlimited number of arguments)
