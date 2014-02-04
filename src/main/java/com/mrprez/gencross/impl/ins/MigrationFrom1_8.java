package com.mrprez.gencross.impl.ins;

import com.mrprez.gencross.Property;
import com.mrprez.gencross.Version;
import com.mrprez.gencross.migration.MigrationPersonnage;
import com.mrprez.gencross.migration.Migrator;
import com.mrprez.gencross.value.DoubleValue;

public class MigrationFrom1_8 implements Migrator {

	@Override
	public MigrationPersonnage migrate(MigrationPersonnage migrationPersonnage) throws Exception {
		Property fouille = migrationPersonnage.getProperty("Talents principaux#Fouille");
		Property perception = migrationPersonnage.getProperty("Caracteristiques#Perception");
		double fouilleValue = fouille.getValue().getDouble();
		double fouilleStartValue = ((double)perception.getValue().getInt()) / 2.0;
		fouilleValue = fouilleValue - 1.0 + fouilleStartValue;
		fouille.setValue(new DoubleValue(fouilleValue));
		fouille.getValue().setOffset(new Double(0.5));
		fouille.setMin();
		
		migrationPersonnage.getPluginDescriptor().setVersion(new Version(1,9));
		return migrationPersonnage;
	}

}
