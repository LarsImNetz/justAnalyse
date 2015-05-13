package example5

import java.math.BigDecimal
import org.eclipse.xtend.lib.annotations.Data

@Data class Timers {
	BigDecimal msec

	def static /(Distance d, Speed s) {
		new Timers(d.mm / s.mmPerMsec)
	}
}
