## Multi-threaded Gym Environment Simulation

The code simulates a multi-threaded gym environment, where multiple gym members perform exercises using randomly assigned machines and weights. Below is a functional breakdown of the code:

### 1. App.java (Entry Point)
**Purpose:** The main method initializes a Gym instance and starts the gym session.

**Key Actions:**
- Creates a Gym object with 5 members and a predefined set of available machines.
- Calls `openForToday()`, which starts multiple threads for gym members and a supervisor thread.

### 2. Gym.java
**Purpose:** Represents a gym with machines and members who work out.

**Key Functionalities:**
- `openForToday()`:
  - Uses `IntStream` to create a list of `Thread` objects, each representing a gym member performing exercises.
  - Starts all gym member threads.
  - Creates and starts a supervisor thread.
- `createSupervisor()`:
  - Periodically checks and prints how many members are still exercising.
  - Ends when all members finish their workout.

### 3. Exercise.java
**Purpose:** Defines an exercise routine with a machine, a random weight distribution, and a duration.

**Key Functionalities:**
- Chooses a random `MachineType`.
- Creates a random set of weights with probabilities.
- Assigns a random duration between 1000-3000ms.
- Implements `toString()` to describe the exercise.

### 4. MachineType.java (Enum)
**Purpose:** Represents different gym machines.

**Key Functionalities:**
- Stores human-readable machine names.
- Provides a method `getRandomEquipment()` to pick a random machine.

### 5. Weight.java (Enum)
**Purpose:** Represents different weight sizes in the gym.

**Key Functionalities:**
- Defines three weight categories (5 lbs, 10 lbs, 25 lbs).
- Stores the initial quantity of each weight type.
- Provides a method `getRandomWeight()` to pick a random weight.
