UTEID: crr2494;
FIRSTNAME: Chelsea;
LASTNAME: Rusch;
CSACCOUNT: crusch;
EMAIL: chelsearusch@utexas.edu;

[Program 6]
[Description]
There are 2 java files, one of which is the jcrypt implementation that was linked on the assignment page.
The other is PasswordCrack, which contains the entire implementation.
The program first runs single mangles on each word in the dictionary + user names, then appends/depends
on each word in the dictionary, then runs double mangles.

[Finish]
I found 15/20 on passwd1 in time 180 seconds, and 16/20 in 692 seconds. 
I found 10/20 on passwd2 in time 321 seconds.

[Test Case 1]

[Input]
michael:atbWfKL4etk4U:500:500:Michael Ferris:/home/michael:/bin/bash		
abigail:&i4KZ5wmac566:501:501:Abigail Smith:/home/abigail:/bin/tcsh
samantha:(bUx9LiAcW8As:502:502:Samantha Connelly:/home/samantha:/bin/bash
tyler:<qt0.GlIrXuKs:503:503:Tyler Jones:/home/tyler:/bin/tcsh
alexander:feohQuHOnMKGE:504:504:Alexander Brown:/home/alexander:
james:{ztmy9azKzZgU:505:505:James Dover:/home/james:/bin/bash
benjamin:%xPBzF/TclHvg:506:506:Benjamin Ewing:/home/benjamin:/bin/bash
morgan:khnVjlJN3Lyh2:507:507:Morgan Simmons:/home/morgan:/bin/bash
jennifer:e4DBHapAtnjGk:508:508:Jennifer Elmer:/home/jennifer:/bin/bash
nicole:7we09tBSVT76o:509:509:Nicole Rizzo:/home/nicole:/bin/tcsh
evan:3dIJJXzELzcRE:510:510:Evan Whitney:/home/evan:/bin/bash
jack:jsQGVbJ.IiEvE:511:511:Jack Gibson:/home/jack:/bin/bash
victor:w@EbBlXGLTue6:512:512:Victor Esperanza:/home/victor:
caleb:8joIBJaXJvTd2:513:513:Caleb Patterson:/home/caleb:/bin/bash
nathan:nxsr/UAKmKnvo:514:514:Nathan Moore:/home/nathan:/bin/ksh
connor:gwjT8yTnSCVQo:515:515:Connor Larson:/home/connor:/bin/bash
rachel:KelgNcBOZdHmA:516:516:Rachel Saxon:/home/rachel:/bin/bash
dustin:5WW698tSZJE9I:517:517:Dustin Hart:/home/dustin:/bin/csh
maria:!cI6tOT/9D2r6:518:518:Maia Salizar:/home/maria:/bin/zsh
paige:T8jwuve9rQBo.:519:519:Paige Reiser:/home/paige:/bin/bash

[Output]
Found password: michael
For user: michael
In 0 seconds

Found password: Salizar
For user: maria
In 0 seconds

Found password: liagiba
For user: abigail
In 0 seconds

Found password: amazing
For user: samantha
In 2 seconds

Found password: eeffoc
For user: tyler
In 15 seconds

Found password: doorrood
For user: jennifer
In 21 seconds

Found password: enoggone
For user: connor
In 30 seconds

Found password: Impact
For user: evan
In 34 seconds

Found password: keyskeys
For user: nicole
In 37 seconds

Found password: sATCHEL
For user: jack
In 54 seconds

Found password: squadro
For user: alexander
In 58 seconds

Found password: THIRTY
For user: victor
In 60 seconds

Found password: icious
For user: james
In 63 seconds

Found password: abort6
For user: benjamin
In 66 seconds

Found password: rdoctor
For user: morgan
In 180 seconds

Found password: teserP
For user: caleb
In 692 seconds

In total, I can crack 16/20 passwords in time 692 seconds.
I can not crack 4/20 passwords, the list is
nathan
rachel
dustin
paige

[Test Case 2]


[Input]

michael:atQhiiJLsT6cs:500:500:Michael Ferris:/home/michael:/bin/bash		
abigail:&ileDTgJtzCRo:501:501:Abigail Smith:/home/abigail:/bin/tcsh
samantha:(bt0xiAwCf7nA:502:502:Samantha Connelly:/home/samantha:/bin/bash
tyler:<qf.L9z1/tZkA:503:503:Tyler Jones:/home/tyler:/bin/tcsh
alexander:fe8PnYhq6WoOQ:504:504:Alexander Brown:/home/alexander:
james:{zQOjvJcHMs7w:505:505:James Dover:/home/james:/bin/bash
benjamin:%xqFrM5RVA6t6:506:506:Benjamin Ewing:/home/benjamin:/bin/bash
morgan:kh/1uC5W6nDKc:507:507:Morgan Simmons:/home/morgan:/bin/bash
jennifer:e4EyEMhNzYLJU:508:508:Jennifer Elmer:/home/jennifer:/bin/bash
nicole:7wKTWsgNJj6ac:509:509:Nicole Rizzo:/home/nicole:/bin/tcsh
evan:3d1OgBYfvEtfg:510:510:Evan Whitney:/home/evan:/bin/bash
jack:js5ctN1leUABo:511:511:Jack Gibson:/home/jack:/bin/bash
victor:w@FxBZv.d0y/U:512:512:Victor Esperanza:/home/victor:
caleb:8jGWbU0xbKz06:513:513:Caleb Patterson:/home/caleb:/bin/bash
nathan:nxr9OOqvZjbGs:514:514:Nathan Moore:/home/nathan:/bin/ksh
connor:gw9oXmw1L08RM:515:515:Connor Larson:/home/connor:/bin/bash
rachel:KenK1CTDGr/7k:516:516:Rachel Saxon:/home/rachel:/bin/bash
dustin:5Wb2Uqxhoyqfg:517:517:Dustin Hart:/home/dustin:/bin/csh
maria:!cSaQELm/EBV.:518:518:Maia Salizar:/home/maria:/bin/zsh
paige:T8U5jQaDVv/o2:519:519:Paige Reiser:/home/paige:/bin/bash

[Output]
Found password: cOnNeLlY
For user: samantha
In 0 seconds

Found password: Saxon
For user: abigail
In 0 seconds

Found password: ellows
For user: jack
In 7 seconds

Found password: dIAMETER
For user: morgan
In 22 seconds

Found password: eltneg
For user: tyler
In 33 seconds

Found password: INDIGNITIES
For user: nicole
In 38 seconds

Found password: tremors
For user: michael
In 72 seconds

Found password: zoossooz
For user: caleb
In 78 seconds

Found password: ^bribed
For user: evan
In 173 seconds

Found password: enchant$
For user: james
In 321 seconds

In total, I can crack 10/20 passwords in time 321 seconds.
I can not crack 10/20 passwords, the list is
alexander
benjamin
jennifer
victor
nathan
connor
rachel
dustin
maria
paige
