#!/bin/sh

npm init --yes

npm install --save-dev gulp gulp-babel gulp-sourcemaps gulp-concat babel-preset-latest babel-plugin-transform-object-rest-spread babel-plugin-transform-es2015-destructuring browser-sync

mkdir src
mkdir dist
touch gulpfile.js
touch src/index.js
touch index.html
