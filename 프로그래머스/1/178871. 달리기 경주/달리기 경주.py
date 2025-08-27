def solution(players, callings):
    player_rank_map = {player: i for i, player in enumerate(players)}
    rank_player_map = {i: player for i, player in enumerate(players)}
    
    for called_player in callings:
        current_rank = player_rank_map[called_player]
        overtaken_rank = current_rank - 1
        
        overtaken_player = rank_player_map[overtaken_rank]
        
        player_rank_map[called_player] = overtaken_rank
        player_rank_map[overtaken_player] = current_rank
        
        rank_player_map[overtaken_rank] = called_player
        rank_player_map[current_rank] = overtaken_player
        
    return [rank_player_map[i] for i in range(len(players))]