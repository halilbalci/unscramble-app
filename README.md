Unscramble App
===================================

Starter code for Android Basics codelab - Store the data in a ViewModel

Unscramble is  a single player game app that displays scrambled words. To play the game, player has
to make a word using all the letters from the displayed scrambled word.

Used in the [Android Basics with Kotlin](https://developer.android
.com/courses/android-basics-kotlin/course) course.


Pre-requisites
--------------

You need to know:
- Knowledge about Fragments.
- How to design a layout in ConstraintLayout.
- Able to write control flow statements (if / else, when statements).
- Able to update the UI of the app based on user input.
- Able to add a click listener to a Button.


Getting Started
---------------

1. Download and run the app.

Problems with the starter code
---------------
As you played the game, you may have observed the following bugs:

On clicking the Submit button, the app does not check the player's word. The player always scores points.
There is no way to end the game. The app lets you play beyond 10 words.
The game screen shows a scrambled word, player's score, and word count. Change the screen orientation by rotating the device or emulator. Notice that the current word, score, and word count are lost and the game restarts from the beginning.
Main issues in the app
The starter app doesn't save and restore the app state and data during configuration changes, such as when the device orientation changes.

You could resolve this issue using the onSaveInstanceState() callback. However, using the onSaveInstanceState() method requires you to write extra code to save the state in a bundle, and to implement logic to retrieve that state. Also, the amount of data that can be stored is minimal.

You can resolve these issues using the Android Architecture components that you learn about in this pathway.


License
-------

Copyright (C) 2020 The Android Open Source Project.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

