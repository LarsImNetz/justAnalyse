"use strict";

var gulp = require("gulp");
var sass = require("gulp-sass");
var rename = require("gulp-rename");
var autoprefixer = require("gulp-autoprefixer");
var sourcemaps = require("gulp-sourcemaps");
var gutil = require("gulp-util");
var request = require('request');

var SCSS_SRC = "sass/**/*.scss";
var SCSS_DEST = "css";

// IDEA from: https://gist.github.com/floatdrop/8269868
var exitOnError = true; //set to false when running a watch task

function createSassTask(src, dest) {
	return function () {
		return gulp.src(src)
			.pipe(sass(/*{
				outputStyle : "compressed"
			}*/)
				.on("error", function (err) {
					gutil.log(err.message);
					if (exitOnError) {
						process.exit(1);
					}
					else {
						this.emit("end");
					}
				}))
			.pipe(autoprefixer({
				browsers: ["last 15 versions"],
				cascade: false
			}))
			.pipe(rename({
				extname : ".min.css"
			}))
			.pipe(gulp.dest(dest));
	};
}

gulp.task("sass:sass", createSassTask(SCSS_SRC, SCSS_DEST));
gulp.task("sass", [
	"sass:sass"
]);

gulp.task("sass:watch", function () {
	exitOnError = false;
	gulp.watch(SCSS_SRC, ["sass:sass"]);
});

gulp.task("watch", [
	"sass:watch"
]);

gulp.task("default", [
	"sass"
]);
