# Android

Standard code for variable name, class name, method name, bracket position, etc please follow this one http://google.github.io/styleguide/javaguide.html

The architecture of this application are based on two programming models:

1. Functional Reactive Programming. This programming model powers almost all the layers in the application, please read this one https://github.com/ReactiveX/RxJava/wiki
2. Benih style programming, please check this out link for detail http://zetbaitsu.github.io/Benih/

These programming models enables us to focus on key points:

1. Make the simplest code but still powerfull, no more one hundred line of fucking code in activity or fragment :v
	
2. Easy to mantain, readable, declarative and multi threading so don't fucking with UI thread.

3. And make beauty code because code is like a poem.


## Layers

To implement separation of concerns, there are several layers on this application. Depending on the complexity of its implementation, each feature will use 1 to 4 layers.

Those layers are:

1. The View layer
2. The Presenter layer
3. The Storage layer
4. The Network layer

The communication flow between those layers are strictly sequential, in the sense that the larger number of the layer won't be succeeded by the smaller layer number. For example:

1. `View layer` -> `Presenter layer` -> `Network layer` is permitted
2. `View layer` -> `Network layer` -> `Presenter layer` is **not** permitted

## Data Structure
```
└─ sigap
   ├─ users
   |  └─ userId
   |     └─ birthDate
   |     └─ email
   |     └─ fromApps
   |     └─ male
   |     └─ name
   |     └─ status
   |     └─ userId
   |
   ├─ userLocations
   |  └─ userId
   |     └─ g
   |     └─ l
   |        └─ 0
   |        └─ 1
   |
   ├─ userTrusted
   |  └─ userId
   |     └─ userIds
   |
   ├─ covers
   |  └─ userId
   |     └─ owner
   |     └─ destination
   |     └─ open
   |     └─ userIds
   |
   ├─ coverMessages
   |  └─ userId
   |     └─ userId
   |     └─ date
   |     └─ content
   |
   ├─ cases
   |  └─ caseId
   |     └─ date
   |     └─ owner
   |     └─ open
   |     └─ caseId
   |
   ├─ caseLocations
   |  └─ caseId
   |     └─ g
   |     └─ l
   |        └─ 0
   |        └─ 1
   |
   ├─ userCases
   |  └─ userId
   |     └─ caseIds
   |
   ├─ helperCases
   |  └─ caseId
   |     └─ userIds
   |
   ├─ userHelps
   |  └─ userId
   |     └─ caseIds
   |
   ├─ caseMessages
   |  └─ caseId
   |     └─ userId
   |     └─ date
   |     └─ content
   |
   ├─ importantContacts
   |  └─ contactId
   |     └─ name
   |     └─ numbers
   |     └─ userId
   |     └─ address
   |     └─ avgRate
   |     └─ totalRate
   |     └─ totalUserRate
   |     └─ contactId
   |
   ├─ userContacts
   |  └─ userId
   |     └─ contactIds
   |
   ├─ comments
   |  └─ contactId
   |     └─ userId
   |     └─ date
   |     └─ content
   |
   └─ bookmarkContacts
      └─ userId
         └─ contactIds
```


## Other Notes

**TODO**

License
-------
    Copyright (c) 2015 SatuSatuDua.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
