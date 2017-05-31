const gulp = require('gulp');
const sourcemaps = require('gulp-sourcemaps');
const babel = require('gulp-babel');
const concat = require('gulp-concat');
const browserSync = require('browser-sync').create();

gulp.task('build', () => {
	return gulp.src('./src/**/*.js')
		.pipe(sourcemaps.init())
		.pipe(babel({
			presets: ['es2015'],
			plugins: ['transform-es2015-destructuring', 'transform-object-rest-spread']
		}))
		.pipe(concat('all.js'))
		.pipe(sourcemaps.write('.'))
		.pipe(gulp.dest('./dist'));
});

gulp.task('serve', ['build'], function(cb) {
	browserSync.init({
		server: {
			baseDir: '.'
		}
	});

    gulp.watch('./src/**/*.js', ['build']);
});


gulp.watch(['./dist/*.js', './**/*.html']).on('change', browserSync.reload);

