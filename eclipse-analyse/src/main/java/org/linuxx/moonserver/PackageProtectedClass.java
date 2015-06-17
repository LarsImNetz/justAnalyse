package org.linuxx.moonserver;

class PackageProtectedClass implements InterfaceGetInt {
	public PackageProtectedClass() {
	}

	@Override
	public int getInt() {
		return 1;
	}
}
