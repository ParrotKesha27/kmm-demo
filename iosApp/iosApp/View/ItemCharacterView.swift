//
//  CharacterItemView.swift
//  iosApp
//
//  Created by Ignat Krasnov on 31.01.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ItemCharacterView: View {
    
    var character: Character
    
    var body: some View {
        HStack {
            AsyncImage(url: URL(string: character.image)) { image in
                image
                    .resizable()
                    .cornerRadius(20)
                    .frame(width: 100, height: 100, alignment: .center)
            } placeholder: {
                ProgressView()
                    .frame(width: 100, height: 100, alignment: .center)
            }
            Text(character.name)
        }
    }
}

struct ItemCharacterView_Previews: PreviewProvider {
    static var previews: some View {
        ItemCharacterView(character: Character(id: 0, name: "Rick", status: "Alive", species: "Human", type: "", gender: "Male", origin: Origin(name: "Earth (C-137)", url: "https://rickandmortyapi.com/api/location/1"), location: Origin(name: "Citadel of Ricks", url: "https://rickandmortyapi.com/api/location/3"), image: "https://rickandmortyapi.com/api/character/avatar/1.jpeg", episode: [], url: "", created: ""))
    }
}
