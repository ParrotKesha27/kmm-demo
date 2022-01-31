//
//  CharactersViewModel.swift
//  iosApp
//
//  Created by Ignat Krasnov on 30.01.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

class CharactersViewModel: ObservableObject {
    
    @Published var characters: ListResponse? = nil
    
    var rickApi = RickApi()
    
    func loadCharacters() {
        rickApi.getAllCharacters { result, error in
            self.characters = result
        }
    }
}
