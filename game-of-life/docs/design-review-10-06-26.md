# Design Review

This unorder cells in varargs was the wrong approach. It led to friction and felt awkward as a user of the API.
I knew this was really bad when I wanted to validation of what a correct grid could be, because the user could easily pass in invalid grids.


Next time, List over var args. Could have avoided the equals method rewrite.

```java
assertThat(new Grid(new Cell(State.DEAD,0,0)).nextIteration())
                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0)));
    }
```

# Possible redesigns

Combined design
- Model: Set<Position>, immutable World, next() returns a new World
- Input: World.parse(String), a test helper first. Promote it to production only when needed.
- Output: toString() renders the bounding box, which feeds approvals and AssertJ failure messages.
- Collaborators (stubs): candidates(), Neighborhood, Rule

# Decisions for next run (St. Pauli redo)

## Model
- `World` immutable record wrapping `Set<Position>` of live cells. No `Cell`, no coordinates in cells.
- State = set membership. Present = alive, absent = dead.
- Keep `State` enum at the edge only: `World.stateAt(Position)` and `Rule.next(State, int neighbors) -> State`.
- Set over varargs/List: invalid grids unrepresentable, record equality for free (no `equals`/`hashCode`).

## API (step 1)
- First test: `World.empty().next()` equals `World.empty()`.
- Second: block (still life) forces stubs.
- Last: blinker as validation test.
- Production API is the set. `World.parse` is test sugar until a real caller needs it.

## Stub tree
- `World.next()` -> `candidates()` (live cells + neighbors), `Neighborhood.countAround`, `Rule`.
- Replace the stub hiding the most behavior first.

## Readability
- Text grids: `.` dead, `#` alive, origin top-left, y down.
- Approval tests for `World.next()` and the blinker. Plain assertions for `Rule` and `Neighborhood`.
- Approved files are append-only. Never overwrite one to turn red green.
- Small grids per cycle (1x3, 2x2), one behavior each.
- Render: normalized bounding box for early cycles. Fixed window `render(w, h)` for the blinker.

```
. . .      . # .
# # #  ->  . # .
. . .      . # .
```

## Test list additions
- parse rejects ragged rows and unknown chars (`IllegalArgumentException`)
- render world with negative positions (glider)

## Guardrails
- Avoid helper detours (`toString`/accessor took 3+ cycles last time). Time-box.
- No commented-out assertions. Append-only suite.
- UI is a humble object over `next()` + `render`. Add only after blinker is green. Glider is the smoke test.

## Transfer katas after GoL
- Bowling score, expression parser (strongest recursion).
