package com.book.manager.domain.repository

import com.book.manager.domain.model.Rental

interface RentalRepository {
  /**
   * 本を貸出する
   *
   * @param rental Rental
   */
  fun startRental(rental: Rental)
}
