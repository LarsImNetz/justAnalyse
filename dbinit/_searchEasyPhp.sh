# Dies Script nur per source includen

if [ "$OS" == "Windows_NT" ]; then
    echo -n "Search for EasyPHP"

	EASYPHP=$( find /c -maxdepth 1 -iname 'easyphp*' 2>/dev/null )
	# EASYPHP=$( find /c -maxdepth 1 -iname 'xampp*' 2>/dev/null )
    if [ -z "$EASYPHP" ]; then
		echo " not found, please install, must quit!"
		exit 2
    else
		echo " found installation in $EASYPHP"
    fi
fi
