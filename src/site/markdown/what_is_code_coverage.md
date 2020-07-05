# What is Code Coverage?
## Introduction
> Test, test, test!
Modern programmers should be aware that writing good tests is half of their job. What is a great, complex implementation if you cannot be sure that it works correctly and is immune to regression?

This is where unit tests (tests that focus on the smallest units of code, i.e. methods and single behaviours) come in. They fix aforementioned problems and are a great tool that should be firmly placed in any programmers toolbelt.

## Explaination
Code coverage then is a property of described unit tests. It is described as the percentage of code that is covered by a unit test. 

In practice, that means that any method that is called and any variable that is used in any unit test is marked "covered". The percentage of covered versus all units (pieces) then equals the "code coverage".

A good and diligent programmer who writes unit tests should always strive to keep this percentage as high as possible. *But be warned:* It's not always possible or worthwhile it to reach 100%. If a little bit of efford gets you to 80% and the remaining 20% would need disproportionally more time and effort, that energy is probably better invested in other places.

Filippo Orru, 2020