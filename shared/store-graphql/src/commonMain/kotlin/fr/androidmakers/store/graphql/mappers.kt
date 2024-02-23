package fr.androidmakers.store.graphql

import fr.androidmakers.store.graphql.fragment.RoomDetails
import fr.androidmakers.store.graphql.fragment.SessionDetails
import fr.androidmakers.store.graphql.fragment.SpeakerDetails
import fr.androidmakers.store.model.Room
import fr.androidmakers.store.model.Session
import fr.androidmakers.store.model.SocialsItem
import fr.androidmakers.store.model.Speaker
import fr.androidmakers.store.model.Venue

fun SpeakerDetails.toSpeaker(): Speaker {
  return Speaker(
      id = id,
      name = name,
      badges = emptyList(),
      bio = bio,
      company = company,
      companyLogo = companyLogoUrl,
      country = null,
      featured = false,
      photoUrl = photoUrl,
      socials = socials.map {
        it.toSocialsItem()
      }
  )
}

fun SpeakerDetails.Social.toSocialsItem(): SocialsItem {
  return SocialsItem(
      name = name,
      url = url,
  )
}

fun RoomDetails.toRoom(): Room {
  return Room(
      id = id,
      name = name,
  )
}

fun SessionDetails.toSession(): Session {
  return Session(
      id = id,
      description = description,
      title = title,
      complexity = complexity ?: "",
      language = language ?: "",
      platformUrl = "",
      slido = "",
      speakers = speakers.map { it.id },
      tags = tags,
      videoURL = "",
      roomId = this.room?.id ?: "",
      endsAt = this.endsAt,
      startsAt = this.startsAt,
      isServiceSession = isServiceSession
  )
}

fun GetVenueQuery.Venue.toVenue(): Venue {
  return Venue(
      name = name,
      address = address ?: "",
      coordinates = coordinates ?: "",
      descriptionFr = descriptionFr,
      description = description,
      imageUrl = imageUrl ?: ""
  )
}