//
//  CharactersView.swift
//  iosApp
//
//  Created by Ignat Krasnov on 30.01.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct CharactersView: View {
    @ObservedObject var viewModel: CharactersViewModel = CharactersViewModel()
    
    var body: some View {
        NavigationView {
            if (viewModel.characters != nil) {
                List {
                    ForEach(viewModel.characters!.results, id: \.self) { character in
                        ItemCharacterView(character: character)
                    }
                }
                .navigationTitle("Rick and Morty")
                .navigationBarTitleDisplayMode(.inline)
            }
        }
        .onAppear {
            viewModel.loadCharacters()
        }
    }
}

struct CharactersView_Previews: PreviewProvider {
    static var previews: some View {
        CharactersView()
    }
}
