## How to make jar?
- **STEP-1:** compile all the src files
- **STEP-2:** Make jar
  - `cfe` - create, specify entry point (main class)
  - `-C out .` = include all compiled files from the `out/` directory 
```
javac -d out src/*.java
jar cfe Game.jar GameDriverGUI -C out .
```
