package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.Rental
import com.book.manager.domain.repository.RentalRepository
import com.book.manager.infrastructure.database.mapper.RentalsMapper
import com.book.manager.infrastructure.database.mapper.insert
import com.book.manager.infrastructure.database.record.Rentals
import org.springframework.stereotype.Repository

@Repository
class RentalRepositoryImpl(private val rentalsMapper: RentalsMapper) : RentalRepository {
  override fun startRental(rental: Rental) {
    rentalsMapper.insert(toRecord(rental))
  }

  private fun toRecord(model: Rental): Rentals =
    Rentals(
      bookId = model.bookId,
      userId = model.userId,
      rentalDatetime = model.rentalDatetime,
      returnDeadline = model.returnDeadline
    )
}
