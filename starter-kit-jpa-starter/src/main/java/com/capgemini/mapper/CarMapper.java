package com.capgemini.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.to.CarTo;

public class CarMapper {

	public static CarTo map(CarEntity carEntity) {
		if (carEntity != null) {
			return new CarTo(/* carTo.getId(), */carEntity.getType(), carEntity.getMake(), carEntity.getColor(),
					carEntity.getProductionYear(), carEntity.getPower(), carEntity.getEngine(), carEntity.getMileage());
		}
		return null;
	}

	public static CarEntity map(CarTo carTo) {
		if (carTo != null) {
			return new CarEntity(/* carTo.getId(), */carTo.getType(), carTo.getMake(), carTo.getColor(),
					carTo.getProductionYear(), carTo.getPower(), carTo.getEngine(), carTo.getMileage());
		}
		return null;
	}

	public static List<CarTo> map2To(List<CarEntity> bookEntities) {
		return bookEntities.stream().map(CarMapper::map).collect(Collectors.toList());
	}

	public static List<CarEntity> map2Entity(List<CarTo> bookEntities) {
		return bookEntities.stream().map(CarMapper::map).collect(Collectors.toList());
	}

}
