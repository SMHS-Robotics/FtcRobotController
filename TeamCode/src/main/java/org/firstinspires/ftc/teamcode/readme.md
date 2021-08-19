# SMHS Robotics Code 2k22

This TeamCode folder has the SMHS Robotics code for the FTC 2021-2022 season, a.k.a.
Freight Frenzy.

This year, we are using a third-party library to abstract out some of the harder work:
[FTCLib](https://docs.ftclib.org/ftclib/). FTCLib will manage some low level details of the
drivetrain, vision system, etc. to make our lives a bit easier. 

There is ongoing work to port the [old Java code](https://github.com/SMHS-Robotics/SkyStone/tree/bdfef56f9272c8f283fb02ae31230d8922eef722/TeamCode/src/main/java/org/firstinspires/ftc/teamcode) (from the 2019-2020 season, which was also the last
year we competed). We need to take that code, strip out parts that are specific to SkyStone, and 
then migrate it to use FTCLib (which is terser, and also more mathematically sound).

Current status: Migration theoretically complete for `FreightBot` (untested), `FreightTele` 
(untested). Migration partially complete for `FreightAuto`.

---

This team experimented last year with a move to Kotlin, but is reverting to Java due
to low language knowledge/adoption ("goddamn APCS kids!"). The writer of this README
document maintains that Kotlin is a much better language than Java, but... oh well.