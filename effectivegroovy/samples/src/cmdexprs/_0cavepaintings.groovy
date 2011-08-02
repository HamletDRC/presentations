package cmdexprs

import static cmdexprs.Location.*
import static cmdexprs.Vehicle.*

instructions = []

instructions << new Instruction('stand', busstop, new Duration(5, 'minutes') )
instructions << new Instruction('ride', Basel, new Duration(10, 'stops'), bus)


println instructions.join('\n')

