# Pacman Simulator Challenge

|Developing| Environment | 
| ------------- |:-------------:|
| Language      | Java |
| IDE      | eclipse      |
| Unit test | JUnit4      |
| UI | Comman Line      |

_Assumption: the origin(0, 0) is the SOUTH WEST most corner_

File Description:
1. Pacman.java -- the main class conatining all functions
2. DirectionCheckTest.java -- unit test for direction check
3. MoveCheckTest.java -- unit test for movement check
4. PlaceCheckTest.java -- unit test for place check
5. AllTests.java -- unit test suite for all test

```
Test case1:
place(0,0,north)
move
output: 0, 1, NORTH

Test case2:
place(0,0,north)
left
output: 0, 0, WEST

Test case3:
place(1,2,east)
move()
move()
left()
move()
output: 3, 3, NORTH

Test case4:
place(3,3,south);
move()
left()
move()
right()
move()
move()
output: 4, 0, SOUTH

Test case5:
place(0,4,north);
right();
move();
move();
left();
move();
right();
right();
move();
move();
left();
move();
move();
output: 4, 2, EAST
```