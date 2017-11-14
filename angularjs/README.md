Tagesgeld-Vergleich auf Angular-Basis
=====================================

Developer hints
---------------

1. Clone the repository

    In your working directory use:

    git clone git@git.pkit.hypoport.local:vde/angular-konten.git

1. Install node.js

    T:\99 Temp\Alexander.Buhr\node-v0.10.29-x64.msi

2. Set environment variables 

    HTTP_PROXY and HTTPS_PROXY must point to http://solv013.hypoport.local:3128

3. Create symlink

    In order to use the css from vgl_typo3_v6.git, make sure app/common is linked to /your/absolute/path/to/vgl_typo3_v6/fileadmin/common
    
    For example, in the directory app use from cmd:
    
    mklink /J common C:\Users\User\workspace\vgl_typo3_v6\fileadmin\common
    
4. Install dependencies

    In the project directory run 'npm install' and after that 'npm start', open http://localhost:3000

Available commands in project root folder
-----------------------------------------

* npm install

    install dependencies
* npm test 

    runs unit-tests in browser and watches sources
* npm run test-single-run

    runs units-test in phantomjs once
* npm run clean

    removes the dist directory
* npm run build 

    runs jshint, tests and creates the dist directory with its content ready for deployment
* npm run jshint

    runs jshint
* npm start

    starts server on http://localhost:3000

Editor
------

1. Indent with one tab, not with spaces

2. First use double-quotes, then single-quotes

3. TODO
