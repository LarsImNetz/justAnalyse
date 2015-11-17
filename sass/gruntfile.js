module.exports = function (grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),
        sass: {
            dist: {
                files: {
                    "css/styles.css": "sass/main.scss"
                }
            }
        },
        watch: {
            scripts: {
                files: ["sass/**/*.scss"],
                tasks: ["sass"],
                options: {
                    spawn: false
                }
            }
        }
    });

    grunt.loadNpmTasks("grunt-sass");
    grunt.loadNpmTasks("grunt-contrib-watch");

    grunt.registerTask("default", ["sass"]);
};
