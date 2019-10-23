-- 令牌生产速率
local permitsPerSecond = tonumber(ARGV[1])
-- 要获取的令牌数
local permits = tonumber(ARGV[2])
-- 时间戳
local currentTimeMillis = tonumber(ARGV[3])
-- 前一次填充，这里是以rule来区分的，第一次配置这个rule，此时preFillTime为false
local preFillTime = redis.call('get', KEYS[2])
if (preFillTime == false) then
    redis.call('set', KEYS[1], permitsPerSecond - permits, 'PX', 1000)
    redis.call('set', KEYS[2], currentTimeMillis, 'PX', 1000)
    return 1 -- 1：成功；0：失败
else
    -- 存储的token数
    local storedTokenNum = tonumber(redis.call('get', KEYS[1]))
    -- 时间戳乱了？
    if (tonumber(currentTimeMillis) < tonumber(preFillTime)) then
        if (storedTokenNum ~= false) then
            redis.call('set', KEYS[1], permitsPerSecond - permits, 'PX', 1000)
            return 1
        else
            if (storedTokenNum < permits) then
                return 0
            else
                redis.call('set', KEYS[1], storedTokenNum - permits, 'PX', 1000)
                return 1
            end
        end
    else
        local newPermits = (tonumber(currentTimeMillis) - tonumber(preFillTime)) / 1000 * permitsPerSecond
        -- 计算这段时间生成的令牌数。
        -- 这里其实不是一直生成的，而是每一次触发，计算时间间隔，求出来可生成的令牌数。
        -- redis完成了分布式环境下的处理
        local totalPermits = newPermits + storedTokenNum
        if (permits > totalPermits) then
            return 0
        else
            redis.call('set', KEYS[1], totalPermits - permits, 'PX', 1000)
            redis.call('set', KEYS[2], currentTimeMillis, 'PX', 1000)
            return 1
        end
    end
end